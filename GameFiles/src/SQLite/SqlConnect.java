package SQLite;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlConnect
{

    public static void createSqlTable(){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:monsters.db")) {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists monsters");
            String sql = "create table monster ( theName TEXT NOT NULL, theHitPoints INTEGER , theDamageRangeMin INTEGER, " +
                    "theDamageRangeMax INTEGER, theAttackSpeed INTEGER, theAttackAccuracy REAL NOT NULL,  theHealingPercentage REAL NOT NULL," +
                    "theHealPointRangeMin INTEGER , theHealPointRangeMax INTEGER)";
            statement.executeUpdate(sql);
            statement.executeUpdate("insert into monster values('Gremlin', 70, 15, 30, 5, .8, .4, 20, 40)");
            statement.executeUpdate("insert into monster values('Ogre', 200, 30, 60, 2, .6, .1, 30, 60)");
            statement.executeUpdate("insert into monster values('Skeleton', 100, 30, 50, 3, .8, .3, 30, 50)");
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            //System.err.println(e.getMessage());
        }
        // connection close failed.
    }

    public static ArrayList<ArrayList<Object>> getMonsters(){
        ArrayList<ArrayList<Object>> listOfMonsters  = new ArrayList<>();
        for(int i=0; i < 3; i++) {
            listOfMonsters.add(new ArrayList<>());
        }
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:monsters.db")) {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from monster");
            int count = 0;
            while (rs.next()) {
                // read the result set
                listOfMonsters.get(count).add(rs.getString("theName"));
                listOfMonsters.get(count).add(rs.getInt("theHitPoints"));
                listOfMonsters.get(count).add(rs.getInt("theDamageRangeMin"));
                listOfMonsters.get(count).add(rs.getInt("theDamageRangeMax"));
                listOfMonsters.get(count).add(rs.getInt("theAttackSpeed"));
                listOfMonsters.get(count).add(rs.getDouble("theAttackAccuracy"));
                listOfMonsters.get(count).add(rs.getDouble("theHealingPercentage"));
                listOfMonsters.get(count).add(rs.getInt("theHealPointRangeMin"));
                listOfMonsters.get(count).add(rs.getInt("theHealPointRangeMax"));
                count++;

            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        // connection close failed.
        return listOfMonsters;
    }

    public static ArrayList<Object> getGremlinList(){
        ArrayList<ArrayList<Object>> list1;
        createSqlTable();
        list1 = getMonsters();
        return new ArrayList<>(list1.get(0));
    }

    public static ArrayList<Object> getOgreList(){
        ArrayList<ArrayList<Object>> list1;
        createSqlTable();
        list1 = getMonsters();
        return new ArrayList<>(list1.get(1));
    }

    public static ArrayList<Object> getSkeletonList(){
        ArrayList<ArrayList<Object>> list1;
        createSqlTable();
        list1 = getMonsters();
        return new ArrayList<>(list1.get(2));
    }


}