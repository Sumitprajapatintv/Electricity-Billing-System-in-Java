/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

/**
 *
 * @author Sumit Prajapati
 */
import java.awt.*;
import java.util.Objects;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

class RendererHighlighted extends DefaultTableCellRenderer {
  private final JTextField searchField;
  public RendererHighlighted(JTextField searchField) {
    this.searchField = searchField;
  }
  @Override public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected, boolean hasFocus,
      int row, int column) {
    String txt = Objects.toString(value, "");
    String pattern = searchField.getText();

    if (Objects.nonNull(pattern) && !pattern.isEmpty()) {
      Matcher matcher = Pattern.compile(pattern).matcher(txt);
      int pos = 0;
      StringBuilder buf = new StringBuilder("<html>");
      while (matcher.find(pos)) {
        int start = matcher.start();
        int end   = matcher.end();
        buf.append(String.format(
            "%s<span style='color:#000000; background-color:#FFFF00'>%s</span>",
            txt.substring(pos, start), txt.substring(start, end)));
        pos = end;
      }
      buf.append(txt.substring(pos));
      txt = buf.toString();
    }
    super.getTableCellRendererComponent(table, txt, isSelected, hasFocus, row, column);
    return this;
  }
}

public class HtmlHighlightCellTest {
  public JComponent makeUI() {
    String[] columnNames = {"A", "B"};
    Object[][] data = {
      {"aaa", "bbaacc"}, {"bbb", "defg"},
      {"ccccbbbbaaabbbbaaeabee", "xxx"}, {"dddaaabbbbb", "ccbbaa"},
      {"cc cc bbbb aaa bbbb e", "xxx"}, {"ddd aaa b bbbb", "cc bbaa"}
    };
    TableModel model = new DefaultTableModel(data, columnNames) {
      @Override public boolean isCellEditable(int row, int column) {
        return false;
      }
      @Override public Class<?> getColumnClass(int column) {
        return String.class;
      }
    };
    JTable table = new JTable(model);
    table.setFillsViewportHeight(true);
    TableRowSorter<? extends TableModel> sorter = new TableRowSorter<>(model);
    table.setRowSorter(sorter);

    JTextField field = new JTextField();
    RendererHighlighted renderer = new RendererHighlighted(field);
    table.setDefaultRenderer(String.class, renderer);
    field.getDocument().addDocumentListener(new DocumentListener() {
      @Override public void insertUpdate(DocumentEvent e) {
        update();
      }
      @Override public void removeUpdate(DocumentEvent e) {
        update();
      }
      @Override public void changedUpdate(DocumentEvent e) {}
      private void update() {
        String pattern = field.getText().trim();
        if (pattern.isEmpty()) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter("(?i)" + pattern));
        }
      }
    });

    JPanel sp = new JPanel(new BorderLayout(2, 2));
    sp.add(new JLabel("regex pattern:"), BorderLayout.WEST);
    sp.add(field);
    sp.add(Box.createVerticalStrut(2), BorderLayout.SOUTH);
    sp.setBorder(BorderFactory.createTitledBorder("Search"));
    JPanel p = new JPanel(new BorderLayout(2, 2));
    p.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    p.add(sp, BorderLayout.NORTH);
    p.add(new JScrollPane(table));
    return p;
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new HtmlHighlightCellTest().makeUI());
      f.pack();
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}