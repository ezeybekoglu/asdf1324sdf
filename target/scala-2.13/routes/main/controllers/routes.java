// @GENERATOR:play-routes-compiler
// @SOURCE:C:/test/scala1/third/conf/routes
// @DATE:Wed Nov 24 20:28:17 EET 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAppController AppController = new controllers.ReverseAppController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAppController AppController = new controllers.javascript.ReverseAppController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
