package br.com.cresol.desafio.converter;

import java.util.List;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
@SuppressWarnings("unchecked")
public class EntityDtoConverter<T> {
	private ModelMapper modelMapper = new ModelMapper();
	
	public EntityDtoConverter<T> build(boolean setAmbiguityIgnored){
		modelMapper.getConfiguration().setAmbiguityIgnored(setAmbiguityIgnored);
		return this;
	}
	
	
	
	public T  converterToDTO(T t,Object obj) {
		return (T) modelMapper.map(obj, t.getClass());
	}

	public T  converterToEntity(T t,Object obj) {
		return (T) modelMapper.map(obj, t.getClass());
	}

	public List<T>   converterToDTOList(List<T> ts,List<? extends Object> objts,Class<T> clazz) {
		for(Object entity:objts) {
			T dto = (T) getInstanceClass(clazz);
			converterToDTO(dto, entity);
			ts.add(dto);
		}
		return ts;
	}
	
	public  List<T>  converterToEntityList(List<T> ts,List<? extends Object> objts,Class<T> clazz) {
		for(Object dto:objts) {				
			T entity = (T) getInstanceClass(clazz);
			converterToEntity(entity, dto);
			ts.add(entity);
		}
		return ts;
	}

	private Object getInstanceClass(Class<T> clazz) {
		try {
			return Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			Logger.getLogger(this.getClass()).errorf("Erro ao converter Objeto.", e);
		}
		return null;
	}
}
	
