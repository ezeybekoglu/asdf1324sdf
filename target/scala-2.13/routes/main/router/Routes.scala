// @GENERATOR:play-routes-compiler
// @SOURCE:C:/test/scala1/third/conf/routes
// @DATE:Wed Nov 24 20:28:17 EET 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.modules.reactivemongo.PathBindables._

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  AppController_0: controllers.AppController,
  // @LINE:17
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    AppController_0: controllers.AppController,
    // @LINE:17
    Assets_1: controllers.Assets
  ) = this(errorHandler, AppController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AppController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.AppController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """healthcheck""", """controllers.AppController.getHealth()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messages""", """controllers.AppController.getTwits(page:Int ?= 1, count:Int ?= 10, username:Option[String], tag:Option[String])"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messages/""" + "$" + """id<[^/]+>""", """controllers.AppController.getTwit(id:reactivemongo.bson.BSONObjectID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messages""", """controllers.AppController.insertTwit()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messages/""" + "$" + """id<[^/]+>""", """controllers.AppController.deleteTwit(id:reactivemongo.bson.BSONObjectID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_AppController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_AppController_index0_invoker = createInvoker(
    AppController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_AppController_getHealth1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("healthcheck")))
  )
  private[this] lazy val controllers_AppController_getHealth1_invoker = createInvoker(
    AppController_0.getHealth(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppController",
      "getHealth",
      Nil,
      "GET",
      this.prefix + """healthcheck""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_AppController_getTwits2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messages")))
  )
  private[this] lazy val controllers_AppController_getTwits2_invoker = createInvoker(
    AppController_0.getTwits(fakeValue[Int], fakeValue[Int], fakeValue[Option[String]], fakeValue[Option[String]]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppController",
      "getTwits",
      Seq(classOf[Int], classOf[Int], classOf[Option[String]], classOf[Option[String]]),
      "GET",
      this.prefix + """messages""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AppController_getTwit3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messages/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AppController_getTwit3_invoker = createInvoker(
    AppController_0.getTwit(fakeValue[reactivemongo.bson.BSONObjectID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppController",
      "getTwit",
      Seq(classOf[reactivemongo.bson.BSONObjectID]),
      "GET",
      this.prefix + """messages/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_AppController_insertTwit4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messages")))
  )
  private[this] lazy val controllers_AppController_insertTwit4_invoker = createInvoker(
    AppController_0.insertTwit(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppController",
      "insertTwit",
      Nil,
      "POST",
      this.prefix + """messages""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_AppController_deleteTwit5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messages/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AppController_deleteTwit5_invoker = createInvoker(
    AppController_0.deleteTwit(fakeValue[reactivemongo.bson.BSONObjectID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppController",
      "deleteTwit",
      Seq(classOf[reactivemongo.bson.BSONObjectID]),
      "DELETE",
      this.prefix + """messages/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_AppController_index0_route(params@_) =>
      call { 
        controllers_AppController_index0_invoker.call(AppController_0.index())
      }
  
    // @LINE:8
    case controllers_AppController_getHealth1_route(params@_) =>
      call { 
        controllers_AppController_getHealth1_invoker.call(AppController_0.getHealth())
      }
  
    // @LINE:9
    case controllers_AppController_getTwits2_route(params@_) =>
      call(params.fromQuery[Int]("page", Some(1)), params.fromQuery[Int]("count", Some(10)), params.fromQuery[Option[String]]("username", None), params.fromQuery[Option[String]]("tag", None)) { (page, count, username, tag) =>
        controllers_AppController_getTwits2_invoker.call(AppController_0.getTwits(page, count, username, tag))
      }
  
    // @LINE:10
    case controllers_AppController_getTwit3_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectID]("id", None)) { (id) =>
        controllers_AppController_getTwit3_invoker.call(AppController_0.getTwit(id))
      }
  
    // @LINE:12
    case controllers_AppController_insertTwit4_route(params@_) =>
      call { 
        controllers_AppController_insertTwit4_invoker.call(AppController_0.insertTwit())
      }
  
    // @LINE:14
    case controllers_AppController_deleteTwit5_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectID]("id", None)) { (id) =>
        controllers_AppController_deleteTwit5_invoker.call(AppController_0.deleteTwit(id))
      }
  
    // @LINE:17
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
