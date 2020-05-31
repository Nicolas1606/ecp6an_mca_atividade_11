package EX11_Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import EX11_Model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findOneByLoginAndSenha(String login, String senha);

}