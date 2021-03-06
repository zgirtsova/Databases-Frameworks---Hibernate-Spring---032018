package ex.controller;

import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DTOConvertUtil {

    public static <S, D> D convert(S source, Class<D> destinationClass) {
        ModelMapper mapper = new ModelMapper();
        D result = mapper.map(source, destinationClass);
        return result;
    }

    public static <S, D> List<D> convert(Iterable<S> sourceIter, Class<D> destinationClass) {
        ModelMapper mapper = new ModelMapper();
        List<D> resultList = new ArrayList<>();
        for (S s : sourceIter) {
            D d = convert(s, destinationClass);
            resultList.add(d);
        }

        return resultList;
    }

    public static <S, D> List<D> convertList(List<S> sourceList, Class<D> destinationClass) {
        ModelMapper mapper = new ModelMapper();
        List<D> resultList = new ArrayList<>();
        for (S sourceObject : sourceList) {
            D mappedObject = mapper.map(sourceObject, destinationClass);
            resultList.add(mappedObject);
        }
        return resultList;
    }

    public static <S, D> Set<D> convertToSet(Iterable<S> sourceIter, Class<D> destinationClass) {
        ModelMapper mapper = new ModelMapper();
        Set<D> resultSet = new HashSet<>();
        for (S s : sourceIter) {
            D d = convert(s, destinationClass);
            resultSet.add(d);
        }

        return resultSet;
    }

    public static <S, D> D convertCustom(S source, Class<D> destClass, ExpressionMap<S, D>... exprMaps) {
        ModelMapper mapper = new ModelMapper();
        TypeMap<S, D> typeMap = mapper.createTypeMap((Class<S>) source.getClass(), destClass);
        for (ExpressionMap<S, D> exprMap : exprMaps) {
            typeMap.addMappings(exprMap);
        }
        return typeMap.map(source);
    }
}
