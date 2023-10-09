package ma.yc.airafraik.presistence;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class CustomPresistenceUnitInfo implements PersistenceUnitInfo {
    @Override
    public String getPersistenceUnitName() {
        return "airafraik-presistence-unit";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "jakarta.persistence.jpa.PersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://127.0.0.1:5332/AIRAFRIK");
        hikariDataSource.setUsername("pc");
        hikariDataSource.setPassword("password");
        hikariDataSource.setDriverClassName("org.postgresql.Driver");
        return hikariDataSource;

    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return null;
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of(
                "ma.yc.entites.AdministrateurEntity",
                "ma.yc.entities.ClientEntity",
                "ma.yc.entities.LogEntity",
                "ma.yc.entities.AeroportEntity",
                "ma.yc.entities.VolEntity",
                "ma.yc.entities.PaymentEntity",
                "ma.yc.entities.ReservationEntity",
                "ma.yc.entities.VilleEntity",
                "ma.yc.entities.VilleImageEntity",
                "ma.yc.entities.VolExtrasEntity",
                "ma.yc.entities.SocieteAerienneEntity"

                );
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
