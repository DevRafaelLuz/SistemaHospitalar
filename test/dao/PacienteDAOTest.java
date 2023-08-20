package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import modelo.Paciente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PacienteDAOTest {
    
    @Mock
    private PacienteDAO pacienteDao;
    
    public PacienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestaContatos() throws ParseException, SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Paciente paciente = new Paciente(19, "Rodrigo", "Rua E", sdf.parse("12/02/1983"), "(41) 9356-6543", "456.789.123-00", "", "", 3);
        Mockito.when(pacienteDao.consultar(19)).thenReturn(paciente);

        Paciente p = pacienteDao.consultar(19);
        assertEquals(p.getNome(), "Rodrigo");
        assertEquals(p.getEndereco(), "Rua E");
        assertEquals(p.getDataNascimento(), "12/02/1983");
        assertEquals(p.getTelefone(), "(41) 9356-6543");
        assertEquals(p.getTelefone(), "456.789.123-00");
        assertEquals(p.getConvenio(), 3);
    }
    
}
