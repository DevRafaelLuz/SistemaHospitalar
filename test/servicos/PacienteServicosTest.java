package servicos;

import dao.PacienteDAO;
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

public class PacienteServicosTest {
    
    private PacienteDAO pacienteDao;
    
    public PacienteServicosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pacienteDao = new PacienteDAO();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testarBuscaNomePaciente() throws SQLException  {
        Paciente pacienteEncontrado = pacienteDao.consultar(1);
        assertEquals("Maria da Silva", pacienteEncontrado.getNome());
    }
    
    @Test
    public void testarBuscaCpfPaciente() throws SQLException {
        Paciente pacienteEncontrado = pacienteDao.consultar(1);
        assertEquals("123.456.789-00", pacienteEncontrado.getCpf());
    }
    
    @Test
    public void testarBuscaEnderecoPaciente() throws SQLException {
        Paciente pacienteEncontrado = pacienteDao.consultar(1);
        assertEquals("Rua A, 123", pacienteEncontrado.getEndereco());
    }
    
    @Test
    public void testarBuscaTelefonePaciente() throws SQLException {
        Paciente pacienteEncontrado = pacienteDao.consultar(1);
        assertEquals("(11) 1234-5678", pacienteEncontrado.getTelefone());
    }
    
    @Test
    public void testarBuscaDataNascPaciente() throws SQLException, ParseException {
        Paciente pacienteEncontrado = pacienteDao.consultar(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        assertEquals(sdf.parse("1990/01/01"), pacienteEncontrado.getDataNascimento());
    }
    
}
