package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManyToManyFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(ManyToManyFacade.class);

    public List<Employee> findEmployee(final String fragmentOfLastname) throws SearchingDatabaseException {
        List<Employee> result = new ArrayList<>();
        String lastnameQuery = "%" + fragmentOfLastname + "%";
        LOGGER.info("Creating query");
        if(fragmentOfLastname.length()==0){
            LOGGER.error(SearchingDatabaseException.ERR_FRAGMENT_NOT_LONG_ENOUGH);
            throw new SearchingDatabaseException(SearchingDatabaseException.ERR_FRAGMENT_NOT_LONG_ENOUGH);
        }
        try {
            LOGGER.info("Searching for employee with fragment: "+fragmentOfLastname);
            result = employeeDao.findEmployeeByFragmentOfLastname(lastnameQuery);
            if(result.size()==0){
                LOGGER.error(SearchingDatabaseException.ERR_CANNOT_FIND_LASTNAME);
                throw new SearchingDatabaseException(SearchingDatabaseException.ERR_CANNOT_FIND_LASTNAME);
            }
        } finally {
            return result;
        }
    }

    public List<Company> findCompany(final String fragmentOfCompanyName) throws SearchingDatabaseException {
        List<Company> result = new ArrayList<>();
        String companyQuery = "%" + fragmentOfCompanyName + "%";
        LOGGER.info("Creating query");
        if(fragmentOfCompanyName.length()==0){
            LOGGER.error(SearchingDatabaseException.ERR_FRAGMENT_NOT_LONG_ENOUGH);
            throw new SearchingDatabaseException(SearchingDatabaseException.ERR_FRAGMENT_NOT_LONG_ENOUGH);
        }
        try {
            LOGGER.info("Searching for company with fragment: "+fragmentOfCompanyName);
            result = companyDao.findCompanyByAnyFragment(companyQuery);
            if(result.size()==0){
                LOGGER.error(SearchingDatabaseException.ERR_CANNOT_FIND_COMPANY);
                throw new SearchingDatabaseException(SearchingDatabaseException.ERR_CANNOT_FIND_COMPANY);
            }
        } finally {
            return result;
        }
    }
}
