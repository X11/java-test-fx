package nl.tkeur;

import eu.lestard.easydi.EasyDI;

class InstanceProvider {
    private static EasyDI edi;

    static void setup() {
        edi = new EasyDI();
        register();
    }

    private static void register() {
        edi.bindProvider(Database.class, Database::new);

        edi.bindInterface(UserRepositoryInterface.class, UserRepository.class);
        edi.bindInterface(AuthenticationServiceInterface.class, AuthenticationService.class);
        edi.bindInterface(DatabaseInterface.class, Database.class);
    }

    static <T> T getInstance(Class<T> requestedType) {
        return edi.getInstance(requestedType);
    }
}
