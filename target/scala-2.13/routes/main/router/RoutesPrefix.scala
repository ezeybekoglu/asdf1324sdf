// @GENERATOR:play-routes-compiler
// @SOURCE:C:/test/scala1/third/conf/routes
// @DATE:Wed Nov 24 20:28:17 EET 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
