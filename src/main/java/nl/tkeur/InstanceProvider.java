package nl.tkeur;

public interface InstanceProvider {
    <T> T getInstance(Class<T> type);
}
