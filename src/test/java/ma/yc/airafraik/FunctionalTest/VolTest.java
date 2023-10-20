package ma.yc.airafraik.FunctionalTest;

import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.entities.VolEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class VolTest {
    Collection<VolEntity> vols;
    @BeforeEach
    void setUp() {
        this.vols = new VolDaoImpl().consulterVols();
    }

    @Test
    void VolTest() {
        Assert.assertNotNull(this.vols);
    }
}