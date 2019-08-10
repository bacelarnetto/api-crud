package br.com.api.impl.validation;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.domain.Pessoa;
import br.com.api.dto.PessoaNewDTO;
import br.com.api.message.FieldMessage;
import br.com.api.repository.PessoaRepository;
import br.com.api.validation.PessoaInsertValidation;



public class PessoaInsertValidatorImpl implements ConstraintValidator<PessoaInsertValidation, PessoaNewDTO> {

	@Autowired
	private PessoaRepository repo;
	
	@Override
	public void initialize(PessoaInsertValidation ann) {
	}

	@Override
	public boolean isValid(PessoaNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		Pessoa aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}