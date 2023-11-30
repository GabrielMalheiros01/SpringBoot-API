package com.apiIc.api.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.apiIc.api.Repositories.BeneficioRepository;
import com.apiIc.api.Repositories.DeficienciaRepository;
import com.apiIc.api.Repositories.EnderecoRepository;
import com.apiIc.api.Repositories.ProfissaoRepository;
import com.apiIc.api.Repositories.UsuarioRepository;
import com.apiIc.api.entities.Usuario;
import com.apiIc.api.entities.Endereco;
import com.apiIc.api.entities.Deficiencia;
import com.apiIc.api.entities.Beneficio;
import com.apiIc.api.entities.Profissao;
import com.apiIc.api.entities.enums.Cor;
import com.apiIc.api.entities.enums.Escolaridade;
import com.apiIc.api.entities.enums.Estado_civil;
import com.apiIc.api.entities.enums.Renda_mensal;
import com.apiIc.api.entities.enums.Sexo;
import com.apiIc.api.entities.enums.Tipo_Moradia;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private DeficienciaRepository deficienciaRepository;
	@Autowired
	private BeneficioRepository beneficioRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ProfissaoRepository profissaoRepository;

	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "gabriel", "bill","09876543211",LocalDate.of(2001, 8, 4),"b123","bill@ufba.br",71909876530L,9193543654L,-12.6860,-38.2100,"432$3",Cor.negro,Escolaridade.ensino_Superior_Imcompleto,Renda_mensal.ate_1_salário_mínimo,Sexo.homem,Estado_civil.solteiro,Tipo_Moradia.alugada);
		Usuario u2 = new Usuario(null, "fabricio", "bricio","04873545431",LocalDate.of(2002, 5, 30),"f123","bricio@ufba.br",71439433433L,1054323654L,-12.697798855550719, -38.32222477978461,"234$3",Cor.branco,Escolaridade.ensino_Superior_Completo,Renda_mensal.acima_de_10_salários_mínimos,Sexo.homem,Estado_civil.casado,Tipo_Moradia.propria);
		
		Deficiencia d1 = new Deficiencia(null,"pé");
		Deficiencia d2 = new Deficiencia(null,"mão");
		
		Endereco e1 = new Endereco(null,"rua da paz","bomba","camacari","bahia","45400000");
		Endereco e2 = new Endereco(null,"rua dalmo goes","graça","valença","bahia","45400000");
		
		Beneficio b1 = new Beneficio(null,"bolsa familia");
		Beneficio b2 = new Beneficio(null,"auxilio familia");	
		
		Profissao p1 = new Profissao(null,"Pedreiro");
		Profissao p2 = new Profissao(null,"Pintor");
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		deficienciaRepository.saveAll(Arrays.asList(d1,d2));
		beneficioRepository.saveAll(Arrays.asList(b1,b2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		profissaoRepository.saveAll(Arrays.asList(p1,p2));
		
		
		u1.getDefs().add(d1);
		u2.getDefs().add(d2);
	
		u1.getBens().add(b1);
		u2.getBens().add(b2);
		
		u1.getEnd().add(e1);
		u2.getEnd().add(e2);
		
		u1.getProfs().add(p1);
		u2.getProfs().add(p2);
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		
		
	
	}

}
