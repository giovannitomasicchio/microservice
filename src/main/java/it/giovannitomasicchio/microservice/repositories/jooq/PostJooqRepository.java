package it.giovannitomasicchio.microservice.repositories.jooq;

import static it.giovannitomasicchio.microservice.jooq.Tables.*;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.giovannitomasicchio.microservice.dto.PostDTO;

@Repository
public class PostJooqRepository {

	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	DSLContext create;
	
	public List<PostDTO> get(Long id) {
		
		Condition condition = DSL.trueCondition();
		
		if(id != null && id.longValue() != 0) {
			condition = condition.and(POST.ID.eq(BigDecimal.valueOf(id)));
		}
		
		return create
				.select(
						POST.ID, POST.DATA, POST.AUTHOR_ID, AUTHOR.NAME, POST_DETAIL.BODY, POST_DETAIL.TITLE).
				from(
						POST
						.join(POST_DETAIL)
							.on(POST.ID.eq(POST_DETAIL.ID))
						.join(AUTHOR)
							.on(POST.AUTHOR_ID.eq(AUTHOR.ID)))
				.where(
						condition
				)
				.fetch()
				.into(PostDTO.class);
	}
	
}
