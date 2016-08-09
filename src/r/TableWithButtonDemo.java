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
import static r.TestTableSortFilter.buildTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class TableWithButtonDemo 
{
 
  
    
        String url = "jdbc:mysql://localhost:3306/customerdata";
        String userid = "root";
        String password = "";
        String sql = "SELECT * FROM customer";
        Connection connection = DriverManager.getConnection( url, userid, password );
        PreparedStatement preparedStatement = null;

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery( sql );

        
        String updatequery;
        /* private Object[][] data1=
            {{"USA", "Washington DC", 280, true},
            {"Canada", "Ottawa", 32, true},
            {"United Kingdom", "London", 60, true},
            {"Germany", "Berlin", 83, true},
            {"France", "Paris", 60, true},
            {"Norway", "Oslo", 4.5, true},
            {"India", "New Delhi", 1046, true}
        };
        */
        /*
           private String[] columnNames1 = { "String", "Integer", "Float", "" };
           private Object[][] data = { { "Dummy", new Integer(12), new Float(12.15), "Consulter" } };
        */
        
        
           // private Object data1[][] =(Object[][]) td.mymetod();
              //private DefaultTableModel model = new DefaultTableModel(data1, columnNames);
    
// JOptionPane.showMessageDialog(null, new JScrollPane(table));
    
/*  
  private TableModel model = new DefaultTableModel(data, columnNames)
  {
    private static final long serialVersionUID = 1L;

    public boolean isCellEditable(int row, int column)
    {
      return column == 3;
    }
  };
  private JTable table = new JTable(model);

  */
            private JFrame frame = new JFrame("Table Demo");       
          
           // private String[] columnNames = {"Country", "Capital", "Population in Millions","g","g","g","g","g","g","button","f"};
            private Object[][] data;
            private TableFromMySqlDatabase td= new TableFromMySqlDatabase();
            private JTable table = new JTable(buildTableModel(rs));
            

  
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
   // columnCount=columnCount+1;
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }
     columnNames.add("Balance_Ammount");
    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
       int kk=0;
       Object value;
       Object value1=0;
       Object value2=0;
       
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
          
            
            
            vector.add(rs.getObject(columnIndex));
            
            if(columnIndex==7)
            {
                value2=rs.getObject(columnIndex);
                System.err.println(value2);  
            }
            
            
            if(columnIndex==8)
            {
                
                
                
                value1 =  rs.getObject(columnIndex);
                System.err.println(value1);  
            }
            
            
            //value=(int)value2 - (int)value1;
            //System.err.println("balance is "+value);
        }
        
        
            
            
            
            
           // table.setValueAt(value, kk, 10);
            //kk++;
            
            
        
        
        
        
        vector.add("ef");
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
    
    
  public TableWithButtonDemo() throws SQLException 
  {
    table.getColumnModel().getColumn(9).setCellRenderer(new ClientsTableButtonRenderer());
    table.getColumnModel().getColumn(9).setCellEditor(new ClientsTableRenderer(new JCheckBox()));
    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    table.setShowHorizontalLines(true);
    table.setShowVerticalLines(false);

    JScrollPane scroll = new JScrollPane(table);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(scroll);
    frame.pack();
    frame.setLocation(150, 150);
    frame.setVisible(true);
  }

  public static void main(String[] args) throws Exception
  {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
          try {
              new TableWithButtonDemo();
          } catch (SQLException ex) {
              Logger.getLogger(TableWithButtonDemo.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    });
  }

  class ClientsTableButtonRenderer extends JButton implements TableCellRenderer
  {
    public ClientsTableButtonRenderer()
    {
      setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      setForeground(Color.black);
      setBackground(UIManager.getColor("Button.background"));
      setText((value == null) ? "" : value.toString());
      return this;
    }
  }
  public class ClientsTableRenderer extends DefaultCellEditor
  {
    private JButton button;
    private String label;
    private boolean clicked;
    private int row, col;
    private JTable table;

    public ClientsTableRenderer(JCheckBox checkBox)
    {
      super(checkBox);
      button = new JButton();
      button.setOpaque(true);
      button.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          fireEditingStopped();
        }
      });
    }
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
      this.table = table;
      this.row = row;
      this.col = column;

      button.setForeground(Color.black);
      button.setBackground(UIManager.getColor("Button.background"));
      label = (value == null) ? "" : value.toString();
      button.setText(label);
      clicked = true;
      return button;
    }
    public Object getCellEditorValue()
    {
      if (clicked)
      {
        
          try {
              String cllname=table.getColumnName(1);
              String cllnameprimarykey=table.getColumnName(0);
              
              System.out.println(cllname+"\t edited columnname custname");
              System.out.println(cllnameprimarykey+"\t primarykey");
              String dd=(String) table.getValueAt(row, 1);
              System.out.println(table.getValueAt(row, 1)+"\t updated value custname");
              
              /*updatequery="'update customer set'+cllname+ '='+table.getValueAt(row, 1)+'where' +cllnameprimarykey+'='+table.getValueAt(row, 0)";
              

*/
              
             
             
              //updatequery="update customer set custname='gandhar' where billno ="+table.getValueAt(row, 0);
              //stmt.executeUpdate(updatequery);
              
              updatequery="update customer set custname = ? where billno = ? ";
              preparedStatement = connection.prepareStatement(updatequery);

			
              
              preparedStatement.setInt(2, (int) table.getValueAt(row, 0));
              preparedStatement.setString(1, (String) table.getValueAt(row, 1));
                        
			
			// execute update SQL stetement
			preparedStatement.executeUpdate();

              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              JOptionPane.showMessageDialog(button, "Column with Value: "+table.getValueAt(row, 1) + " -  Clicked!");
          } catch (SQLException ex) {
              Logger.getLogger(TableWithButtonDemo.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println(ex);
          
          }
      }
      clicked = false;
      return new String(label);
    }

    public boolean stopCellEditing()
    {
      clicked = false;
      return super.stopCellEditing();
    }

    protected void fireEditingStopped()
    {
      super.fireEditingStopped();
    }
  }

}

