package homework7;

/**
 * Created by Connor on 2016/12/26.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class _14211383_张博康_7_StrategiesUI extends JFrame {
    private _14211383_张博康_7_Controller controller;
    // UI中的组件
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTable strategyTable;
    private DefaultTableModel strategyTableModel;
    private JButton deleteButton;
    private JTextField strategyNameField;
    private JTextField strategyIdField;
    private JComboBox strategyTypeBox;
    private JTextField discountField;
    private JButton addButton;
    private JButton updateButton;
    private JComboBox strategyChooseBox;

    _14211383_张博康_7_StrategiesUI(_14211383_张博康_7_Controller controller) {
        this.controller = controller;
        InitUI();
        InitAction();
    }

    private void InitAction() {
        addButton.addActionListener(e -> {
            controller.addSimpleStrategy();
        });

        deleteButton.addActionListener(e -> {
            int select = strategyTable.getSelectedRow();
            if (select == -1)
                JOptionPane.showMessageDialog(null, "请选择一个策略");
            else
                strategyTableModel.removeRow(select);
            controller.deleteStrategy((int)strategyTableModel.getValueAt(select, 0));
        });

    }


    private void InitUI() {
        setVisible(true);
        setSize(400, 480);

        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        tabbedPane1 = new JTabbedPane();
        panel1.add(tabbedPane1, BorderLayout.CENTER);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        tabbedPane1.addTab("查看/删除", panel2);
        final JScrollPane scrollPane1 = new JScrollPane();
        panel2.add(scrollPane1, BorderLayout.CENTER);


        // 设置策略显示表格
        String[] columnName = {"定价策略编号", "策略名称", "定价策略类型", "折扣百分比/每本优惠额度"};
        TableColumnModel columnModel = new DefaultTableColumnModel();
        strategyTable = new JTable(strategyTableModel);
        strategyTable.setColumnModel(columnModel);
        scrollPane1.setViewportView(strategyTable);


        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(panel3, BorderLayout.SOUTH);
        deleteButton = new JButton();
        deleteButton.setText("删除所选策略");
        panel3.add(deleteButton);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        tabbedPane1.addTab("增加/更改", panel4);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(panel5, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("更新策略选择");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("定价策略编号");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("策略名称");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("定价策略类型");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("折扣百分比/每本优惠额度");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(label5, gbc);
        strategyIdField = new JTextField();
        strategyIdField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(strategyIdField, gbc);
        strategyNameField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(strategyNameField, gbc);
        discountField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(discountField, gbc);
        strategyTypeBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("百分比折扣简单策略");
        defaultComboBoxModel1.addElement("绝对值优惠简单策略");
        strategyTypeBox.setModel(defaultComboBoxModel1);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(strategyTypeBox, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(spacer1, gbc);
        strategyChooseBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("不更新策略");
        strategyChooseBox.setModel(defaultComboBoxModel2);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(strategyChooseBox, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel5.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel5.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel5.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel5.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel5.add(spacer6, gbc);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(panel6, gbc);
        addButton = new JButton();
        addButton.setText("添加");
        panel6.add(addButton);
        final JPanel spacer7 = new JPanel();
        panel6.add(spacer7);
        updateButton = new JButton();
        updateButton.setText("更新");
        panel6.add(updateButton);

        add(panel1);
    }
}
