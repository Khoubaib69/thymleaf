package fr.dawan.quizzapp.dtos;

import org.modelmapper.ModelMapper;

public class DtoTools {
	
	private static ModelMapper mapper = new ModelMapper();
	
	public static <TSource, TDestination> TDestination Convert(TSource obj, Class<TDestination> clazz){
		return mapper.map(obj, clazz);
	}

}