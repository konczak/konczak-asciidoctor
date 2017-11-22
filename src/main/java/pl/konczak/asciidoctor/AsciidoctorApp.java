package pl.konczak.asciidoctor;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.SafeMode;

import java.io.File;
import java.util.Map;

import static org.asciidoctor.Asciidoctor.Factory.create;
import static org.asciidoctor.OptionsBuilder.options;

public class AsciidoctorApp {

    private static final String PATH_TO_FILE = ".\\konczak.adoc";

    public static void main(String[] args) {
        Asciidoctor asciidoctor = create();

        File file = new File(PATH_TO_FILE);

        convertToHtml(asciidoctor, file);
        convertToPdf(asciidoctor, file);
    }

    private static void convertToHtml(final Asciidoctor asciidoctor, final File file) {
        Map<String, Object> options = options().safe(SafeMode.SAFE)
                .backend("html")
                .inPlace(true)
                .asMap();

        asciidoctor.convertFile(file, options);
    }

    private static void convertToPdf(final Asciidoctor asciidoctor, final File file) {
        Map<String, Object> options = options().safe(SafeMode.SAFE)
                .backend("pdf")
                .inPlace(true)
                .asMap();

        asciidoctor.convertFile(file, options);
    }
}
