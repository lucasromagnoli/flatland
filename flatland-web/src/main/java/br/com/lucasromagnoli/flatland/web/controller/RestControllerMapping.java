package br.com.lucasromagnoli.flatland.web.controller;

public class RestControllerMapping {
    private RestControllerMapping() {}

    public static final String ERROR_PATH_ROOT                                  = "/error";
    public static final String ERROR_PATH_NOT_FOUND                             = "/404";
    public static final String ERROR_PATH_METHOD_NOT_ALLOWED                    = "/405";
    public static final String ERROR_PATH_INTERNAL_SERVER_ERROR                 = "/500";
}
