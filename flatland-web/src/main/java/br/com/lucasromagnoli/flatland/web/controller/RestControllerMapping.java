package br.com.lucasromagnoli.flatland.web.controller;

/**
 * @author github.com/lucasromagnoli
 * @since 27/01/2020
 */
public class RestControllerMapping {

    private RestControllerMapping() {}

    public static final String ERROR_PATH_ROOT                                  = "/error";
    public static final String ERROR_PATH_NOT_FOUND                             = "/404";
    public static final String ERROR_PATH_METHOD_NOT_ALLOWED                    = "/405";
    public static final String ERROR_PATH_INTERNAL_SERVER_ERROR                 = "/500";

    // TODO: 13/02/2020 - Atualizar o nome da constante, inserindo o sufixo v1
    public static final String AUTH_PATH_ROOT_V1                                = "/v1/auth";
    public static final String AUTH_PATH_GENERATE_TOKEN                         = "/token";

    public static final String V1_USERS_PATH_ROOT                               = "/v1/users";
}
