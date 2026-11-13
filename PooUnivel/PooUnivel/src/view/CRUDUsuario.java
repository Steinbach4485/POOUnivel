package view;

import dao.UsuarioDAO;
import java.awt.*;
import java.security.MessageDigest;
import javax.swing.*;
import model.Usuario;;

public class CRUDUsuario extends JFrame {
    private JTable tabelaUsuarios;
    private DefaultTableModel model;
    private JButton btnNovo, btnEditar, btnExcluir;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public CRUDUsuario() {
        setTitle("Gerenciamento de Usuarios");
        setSize(700,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[] { "ID", "Nome", "Tipo", "Situação", "Data Criação"}, 0) {
            public boolean is CellEditable(int row, int column) {
                return false;
            }
        };
        tabelaUsuarios = new JTable(model);
        JSCrollPane scrollPane = new JScrollPane(tabelaUsuarios);
        add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        btnNovo = new JButton("Novo");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        add(painelBotoes, BorderLayout.SOUTH);

        btnNovo.addActionListener(e -> abrirFormulario(null));
        btnEditar.addActionListener(e -> editarUsuario());
        btnExcluir.addActionListener(e -> excluirUsuario());

        carregarUsuarios();
        setVisible(true);

    }

    private void carregarUsuarios() {
        model.setRouCount(0);
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        for (Usuario u : usuarios) {
            String tipoLegivel = u.getTipo().equals("A") ? "Administrador" : "Usuario";
            String ativoLegivel = u.getAtivo().equals("T")?
                "Ativo" : "Inativo";

            model.addRow(new Object[]{
                u.getId(),
                u.getLogin(),
                tipoLegivel,
                u.getDataCriacao(),
            });
            
        }
        }
    
        private void abrirFormulario(Usuario usuario) {

            FormulaUsuario form = new FormulaUsuario(this, usuario);
            form.setVisible(true);

        }

        private void editarUsuario() {
            int linha = tabelaUsuarios.getSelectedRow();
            if(linha >= 0) {
                int id = (int) model.getValueAt(linha, 0);
                Usuario usuario = usuarioDAO.buscarPorId(id);
                abrirFormulario(usuario);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um usuario" + "para editar!");
            }
        }
        private void excluirUsuario() {
            int linha = tabelaUsuarios.getSelectedRow();
            if(linha >= 0 ) {
                int id = (int) model.getValueAt(linha, 0);
                int confirm = JOptionPane.showConfirmDialog(this, "Deseja" +
                    "realmente excluir este usuario?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        boolean sucesso = usuarioDAO.excluir(id);
                        if(sucesso) {
                            carregarUsuarios();
                            JOptionPane.showMessageDialog(this, "Usuario" + "excluido com sucesso!");

                        }else {
                            JOptionPane.showMessageDialog(this, "Erro ao " +
                                "excluir usuario");
                        }
                    }
            } else {
                JOptionPane.showConfirmDialog(this, "Selecione um usuario " + " para Excluir!");
            }
        }

        public void atualizarTabela() {
            carregarUsuarios();
        }
}
