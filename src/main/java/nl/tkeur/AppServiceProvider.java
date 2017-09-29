package nl.tkeur;

import eu.lestard.easydi.EasyDI;

public class AppServiceProvider {

    private static EasyDI edi;

    public static void setup() {
        edi = new EasyDI();
        register();
    }

    public static void register() {
        edi.bindProvider(InstanceProvider.class, () -> edi::getInstance);
        edi.bindProvider(Database.class, Database::new);
    }

    public static <T> T getInstance(Class<T> requestedType) {
        return edi.getInstance(requestedType);
    }
}
