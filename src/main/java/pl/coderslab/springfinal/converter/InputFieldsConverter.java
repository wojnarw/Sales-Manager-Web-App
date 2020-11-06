package pl.coderslab.springfinal.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.springfinal.entity.InputFields;

public class InputFieldsConverter implements Converter<String, InputFields> {
    @Override
    public InputFields convert(String s) {
        return null;
    }

//    @Autowired
//    AuthorDao authorDao;

//    @Override
//    public InputFields convert(String value) {
//        try {
//            long id = Long.parseLong(value);
//            return authorDao.findOneById(id);
//        } catch (Exception e) {
//            return null;
//        }
//    }
}