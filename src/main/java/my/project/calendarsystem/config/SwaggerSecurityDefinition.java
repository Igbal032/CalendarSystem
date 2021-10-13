package my.project.calendarsystem.config;

import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(securityDefinition = @SecurityDefinition(apiKeyAuthDefinitions = { @ApiKeyAuthDefinition(key = "ApiKey", name = "Authorization", in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER) }))
public interface SwaggerSecurityDefinition {

}