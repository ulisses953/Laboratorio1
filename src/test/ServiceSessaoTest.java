package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import model.Sessao;
import model.User;
import service.ServiceSessao;

public class ServiceSessaoTest {
    public ServiceSessao service1;
    public Sessao sessao1;
    public User user1;
    public User user2;

    @Before
    public void setUp() {
        service1 = new ServiceSessao();
        sessao1 = new Sessao();
        user1 = new User(1, "teste1");
        user2 = new User(2, "teste2");
    }

    @Test
    public void testReservar() {
        try {
            service1.reservar(1, 'a', user1, sessao1);
            var cadeiras = sessao1.getCadeiras();

            assertEquals(user1.getNome(), cadeiras[1][0].getNome());

        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void testAlterar() {
        try {
            service1.alterar(1, 'a', user2, sessao1);
            var cadeiras = sessao1.getCadeiras();

            assertEquals(user2.getNome(), cadeiras[1][0].getNome());

        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void testCancelar() {
        try {
            service1.cancelar(1, 'a', sessao1);
            var cadeiras = sessao1.getCadeiras();

            assertEquals(null, cadeiras[1][0]);

        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void testValidarCadeira() {
        try {
            service1.validarCadeira(sessao1, 1, 1);
            var cadeiras = sessao1.getCadeiras();

            assertEquals(user1.getNome(), cadeiras[1][0].getNome());

        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void testValidadorColuna() {

    }

    @Test
    public void testValidadorLinha() {

    }
}
