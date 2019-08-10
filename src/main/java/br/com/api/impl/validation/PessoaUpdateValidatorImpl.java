package br.com.api.impl.validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.api.domain.Pessoa;
import br.com.api.dto.PessoaDTO;
import br.com.api.message.FieldMessage;
import br.com.api.repository.PessoaRepository;
import br.com.api.validation.PessoaUpdateValidation;

public class PessoaUpdateValidatorImpl implements ConstraintValidator<PessoaUpdateValidation, PessoaDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PessoaRepository repo;
	
	@Override
	public void initialize(PessoaUpdateValidation ann) {
	}

	@Override
	public boolean isValid(PessoaDTO objTO, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Pessoa aux = repo.findByEmail(objTO.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
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