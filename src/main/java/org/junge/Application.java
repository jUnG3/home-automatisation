package org.junge;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.graalvm.nativeimage.ProcessProperties;

import java.nio.file.Paths;

@QuarkusMain
public class Application {

    public static void main(String[] args) {
        Quarkus.run(HomeApplication.class, args);
    }

    public static class HomeApplication implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {
            System.load(Paths.get(ProcessProperties.getExecutableName())
                    .getParent()
                    .resolve("native")
                    .resolve(System.mapLibraryName("JavaCAN-x86_64"))
                    .toString());
            Quarkus.waitForExit();
            return 0;
        }
    }
}
