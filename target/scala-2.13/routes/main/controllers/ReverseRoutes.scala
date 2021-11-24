// @GENERATOR:play-routes-compiler
// @SOURCE:C:/test/scala1/third/conf/routes
// @DATE:Wed Nov 24 20:28:17 EET 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.modules.reactivemongo.PathBindables._

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseAppController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getTwits(page:Int = 1, count:Int = 10, username:Option[String], tag:Option[String]): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "messages" + play.core.routing.queryString(List(if(page == 1) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("page", page)), if(count == 10) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("count", count)), Some(implicitly[play.api.mvc.QueryStringBindable[Option[String]]].unbind("username", username)), Some(implicitly[play.api.mvc.QueryStringBindable[Option[String]]].unbind("tag", tag)))))
    }
  
    // @LINE:8
    def getHealth(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "healthcheck")
    }
  
    // @LINE:14
    def deleteTwit(id:reactivemongo.bson.BSONObjectID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "messages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectID]].unbind("id", id)))
    }
  
    // @LINE:10
    def getTwit(id:reactivemongo.bson.BSONObjectID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "messages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectID]].unbind("id", id)))
    }
  
    // @LINE:12
    def insertTwit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "messages")
    }
  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
