package io.github.devbhuwan.raml.codegen;

import lombok.SneakyThrows;
import org.raml.ramltopojo.RamlToPojoBuilder;
import org.raml.v2.api.model.v10.api.Api;

import java.io.File;
import java.io.IOException;

import static org.raml.ramltopojo.TypeFetchers.fromAnywhere;
import static org.raml.ramltopojo.TypeFinders.everyWhere;

class RamlToPojoCode implements CodeGenerate {

    @Override
    @SneakyThrows(IOException.class)
    public void generate(Api api, String defaultPackage, File outputDirectory) {
        RamlToPojoBuilder.builder(api)
                .inPackage(defaultPackage)
                .fetchTypes(fromAnywhere())
                .findTypes(everyWhere())
                .build().buildPojos()
                .createAllTypes(outputDirectory.getAbsolutePath());
    }
}
