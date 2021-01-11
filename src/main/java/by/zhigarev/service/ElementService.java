package by.zhigarev.service;

import by.zhigarev.dao.ElementDAO;
import by.zhigarev.dao.impl.ElementDAOImpl;
import by.zhigarev.entity.Element;

import java.io.IOException;

public interface ElementService {

    Element getRootElement(String filePath) throws IOException;
}
