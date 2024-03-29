package basededatos;
import basededatos.clases.Municipalidad;
import basededatos.clases.QueryPromedio;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    //DATOS DE VERIFICACION Y CONEXION
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/basededatos";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection con;

    public static void main(String[] args) {

        try {
            Class.forName(DATABASE_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Conexion realizada.");

            //INSERTAR MUNICIPALIDAD
            //insertMunicipalidad("Municipalidad 25 de Mayo");

            //INSERTAR EMPLEADO
            //insertEmpleado("Julian","Ricky","6942021345","julianricky@123",75000,11,"Analista de datos",1);

            //MOSTRAR LOS DATOS PROMEDIO
            System.out.println("------------------------------------------------------");
            System.out.println("Problematica SQL, generando lista: ");
            ArrayList<QueryPromedio> lista = listaPromedio();
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }

            //MOSTRAR LOS DATOS DE LA TABLA MUNICIPALIDADES
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM Municipalidades");
            while(rs1.next()){
                int id_municipalidad = rs1.getInt("id_municipalidad");
                String nombreM = rs1.getString("nombreM");
                System.out.println("MUNICIPALIDAD ID: "+id_municipalidad);
                System.out.println("Nombre de la municipalidad: "+nombreM);
                System.out.println("------------------------------------------------------");
            }
            rs1.close();
            st1.close();

            //MOSTRAR LOS DATOS DE LA TABLA EMPLEADOS
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Empleados");
            while(rs.next()){
                int id_empleado = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                int salario = rs.getInt("salario");
                int antiguedad = rs.getInt("antiguedad");
                String puesto = rs.getString("puesto");

                System.out.println("EMPLEADO ID: "+id_empleado);
                System.out.println("Nombre: "+nombre);
                System.out.println("Apellido: "+apellido);
                System.out.println("Telefono: "+telefono);
                System.out.println("Email: "+email);
                System.out.println("Salario: $"+salario);
                System.out.println("Antiguedad: "+antiguedad +" años.");
                System.out.println("Puesto: "+puesto);
                System.out.println("------------------------------------------------------");
            }
            rs.close();
            st.close();

            //EXCEPCIONES QUE SURJAN EN LA CONEXION SQL
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //ESTA FUNCION INSERTA DATOS EN LA TABLA MUNICIPALIDADES
    private static void insertMunicipalidad(String nombreM) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO municipalidades(nombreM) values(?)");
        ps.setString(1,nombreM);
        ps.execute();
        ps.close();
    }

    //ESTA FUNCION INSERTA DATOS EN LA TABLA EMPLEADOS
    private static void insertEmpleado(String nombre, String apellido, String telefono, String email, int salario, int antiguedad, String puesto,int id_muni) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO empleados(nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni) values(?,?,?,?,?,?,?,?)");
        ps.setString(1,nombre);
        ps.setString(2,apellido);
        ps.setString(3,telefono);
        ps.setString(4,email);
        ps.setInt(5,salario);
        ps.setInt(6,antiguedad);
        ps.setString(7,puesto);
        ps.setInt(8,id_muni);
        ps.execute();
        ps.close();
    }

    //ESTA FUNCION EJECUTA LA FUNCION SQL
    private static ArrayList<QueryPromedio> listaPromedio() throws SQLException{

        ArrayList<QueryPromedio> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT emp.nombre, emp.apellido, emp.telefono, emp.email, emp.puesto, muni.nombreM\n" +
                "FROM empleados AS emp JOIN municipalidades AS muni\n" +
                "ON emp.id_muni = muni.id_municipalidad\n" +
                "WHERE emp.salario>=? AND emp.antiguedad<=? && emp.antiguedad>=?;");
        ps.setInt(1,70000);
        ps.setInt(2,15);
        ps.setInt(3,10);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            lista.add(new QueryPromedio(rs.getString("nombre"),rs.getString("apellido"),rs.getString("telefono"),rs.getString("email"),rs.getString("puesto"),rs.getString("nombreM")));
        }
        return lista;
    }

}
