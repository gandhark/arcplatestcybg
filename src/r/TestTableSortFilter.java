/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r;

/**
 *
 * @author abc
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gandhark
 */

/**
 *
 * @author gandhark
 */
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class TestTableSortFilter extends JPanel {

    
    
    
     String url = "jdbc:mysql://localhost:3306/customerdata";
        String userid = "root";
        String password = "";
        String sql = "SELECT * FROM customer";
    
        
        Connection connection = DriverManager.getConnection( url, userid, password );
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            
            
            
    private String[] columnNames
            = {"Country", "Capital", "Population in Millions","g","g","g","g","g","g"};

    private Object[][] data;
    private TableFromMySqlDatabase td= new TableFromMySqlDatabase();
    
   // private Object data1[][] =(Object[][]) td.mymetod();
            
            
    
    
    

    //private DefaultTableModel model = new DefaultTableModel(data1, columnNames);
    
    private JTable table = new JTable(buildTableModel(rs));
   // JOptionPane.showMessageDialog(null, new JScrollPane(table));
    
    
    
    
  // private JTable jTable = new JTable(model);

    private TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(table.getModel());

    private JTextField jtfFilter = new JTextField();
    private JButton jbtFilter = new JButton("Filter");

    
            
   
        
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
    
    
    
    public void sortData() throws SQLException
    {
       //System.out.println( Arrays.toString(td.mymethod()));
    }
    
    
    
    
    
    public TestTableSortFilter() throws SQLException {
       // System.out.println(td.mymethod());
        this.data = new Object[][]{/*{"USA", "Washington DC", 280, true},
            {"Canada", "Ottawa", 32, true},
            {"United Kingdom", "London", 60, true},
            {"Germany", "Berlin", 83, true},
            {"France", "Paris", 60, true},
            {"Norway", "Oslo", 4.5, true},
            {"India", "New Delhi", 1046, true}*/
            
        };
       //  System.out.println(Arrays.toString(td.mymethod()));
        table.setRowSorter(rowSorter);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                try {
                    JFrame frame = new JFrame("Row Filter");
                    frame.add(new TestTableSortFilter());
                    frame.pack();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TestTableSortFilter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        try
        {
        new TestTableSortFilter().sortData();
        }
        catch (Exception e)
        {
            System.out.println(e);
                }
    }
}
