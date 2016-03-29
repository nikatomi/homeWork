package bll;

public class RepositoryFactory {
    public static Repository createBinarRepositoriy(String nameRepository){
        return new BinarRepasitories(nameRepository);
    }

    public static Repository createCsvRepositoryReflection(String nameRepository){
        return new CsvRepositoriesReflection(nameRepository);
    }
    public static Repository createCsvRepository(String nameRepository){
        return new CsvRepositories(nameRepository);
    }
}
