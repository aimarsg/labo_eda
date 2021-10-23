package eda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ActorTest {

        Actor a1;
        Pelicula p1;
        @BeforeEach
        public void setUp() {

            a1 = new Actor("Naruto");
            p1 = new Pelicula("Jujutsu kaisen", 20000);
            a1.anadirPelicula(p1);

        }
        @AfterEach
        public void tierDown() {
            a1 = null;
            p1 = null;
        }
        @Test
        public void testBuscarPeli() {

            //Peli que no esta
            assertNull(a1.buscarPeli("dead note"));
            //Peli que esta
            assertNotNull(a1.buscarPeli("Jujutsu kaisen"));
        }

        @Test
        public void testAnadirPelicula() {

            //Añadir la pelicula
            Pelicula p2 = new Pelicula("Naruto shimpuden",20000);
            a1.anadirPelicula(p2);
            assertNotNull(a1.buscarPeli("Naruto shimpuden"));
        }

        @Test
        public void testEliminarPeli() {


            //Peli que esta
            assertNotNull(a1.buscarPeli("Jujutsu kaisen"));
            a1.eliminarPeli(p1);
            assertNull(a1.buscarPeli("Jujutsu kaisen"));
            //Peli que no esta
            Pelicula p3 = new Pelicula("Black clover", 20000);
            a1.eliminarPeli(p3);
        }

    }

