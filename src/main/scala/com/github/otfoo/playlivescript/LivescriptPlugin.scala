package com.github.otfoo.playlivescript

import sbt._
import sbt.Keys._
import Keys._
import play.PlayExceptions._
import play.{Project => PlayProject}

object LivescriptPlugin extends Plugin {

  val lsEntryPoints = SettingKey[PathFinder]("play-livescript-entry-points")
  val lsOptions = SettingKey[Seq[String]]("play-livescript-options")
  
  val LivescriptWatcher = PlayProject.AssetsCompiler("livescript",
    _ ** "*.ls",
    lsEntryPoints,
    { (name, min) => name.replace(".ls", if (min) ".min.js" else ".js") },
    { (scriptFile, options) =>
      import scala.util.control.Exception._
      val jsSource = LivescriptCompiler.compile(scriptFile, options)
      // Any error here would be because of LiveScript, not the developer;
      // so we don't want compilation to fail.
      val minified = catching(classOf[CompilationException]).opt(play.core.jscompile.JavascriptCompiler.minify(jsSource, Some(scriptFile.getName())))
      (jsSource, minified, Seq(scriptFile))
    },
    lsOptions
  )

  override val settings = Seq(
    lsEntryPoints <<= (sourceDirectory in Compile).apply(base => (base / "assets" ** "*.ls") --- base / "assets" ** "_*"),
    lsOptions := Seq.empty[String],
    resourceGenerators in Compile <+= LivescriptWatcher
  )

}
