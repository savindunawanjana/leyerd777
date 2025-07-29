package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.CustermerDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.CustormerManegeBO;
import edu.lk.ijse.projectgym.demo76promax.bo.Exseption.Inusedexception;
import edu.lk.ijse.projectgym.demo76promax.bo.Exseption.Notfoundexseption;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CustormerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustormerManegeBOImpl implements CustormerManegeBO {

    private CustormerDAO custormerDAO = DAOFactory.getInstance().getDao(DAOTipes.CUSTOMER);


    @Override
    public List<CustermerDto> getrAllcustormer() throws SQLException,ClassNotFoundException,Notfoundexseption{

        List<Customer> custormerlist = custormerDAO.getAll();

        if(custormerlist.isEmpty()){

    throw  new Notfoundexseption("Custormrs are not Avalable yet");
            //System.out.println("true");

        }


        List<CustermerDto> custermerDtoList = new java.util.ArrayList<>();

        for (Customer customer : custormerlist) {

            CustermerDto custermerDto = new CustermerDto(
                    customer.getCustomerId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getCustomerNumber(),
                    customer.getCustomerBirthday(),
                    customer.getCustomerWeight(),
                    customer.getCustomerEmail(),
                    customer.getCustomerRegisterFees()
            );

            custermerDtoList.add(custermerDto);

        }

        return custermerDtoList;


    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = custormerDAO.getNextIdUnicForthisclass();

        char prefix = 'C';

        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String numberPart = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(numberPart);
            int nextIdNumber = lastIdNumber + 1;
            return String.format(prefix + "%03d", nextIdNumber);
        }

        return prefix + "001";

    }

    @Override
    public String findNameById(String Id) throws SQLException, ClassNotFoundException {
        String name = custormerDAO.findNameById(Id);

        return name == null ? "Custormer is  not found " : name;
    }

    @Override
    public List<String> getAllIds() throws SQLException, ClassNotFoundException {

        List<String> customerList=custormerDAO.getAllIds();
        return customerList;
    }

    @Override
    public String findEmailById(String customerId) throws SQLException, ClassNotFoundException {

        String email = custormerDAO.findEmailById(customerId);
        if(email.isEmpty() ){
            return "ID is not valid for your requirement";
        }
        return email;

    }

    @Override
    public boolean isUserIdExists(String id) throws SQLException, ClassNotFoundException {

       Boolean rsp = custormerDAO.isUserIdExists(id);
       return rsp ;

    }

    @Override
    public String updateCustomer(CustermerDto customer) throws SQLException, ClassNotFoundException {

        Customer costormer = new Customer(

                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getCuctermerNumber(),
                customer.getCuctermerBirthdayMonth(),
                customer.getCuctermerWeight(),
                customer.getCuctermerEmail(),
                customer.getCuctermerRegisterFees()
        );

            Boolean cach = custormerDAO.update(costormer);

            return cach == true ? "Customer updated successfully" : "Customer not updated";
    }

    @Override
    public String saveCustomer(CustermerDto customer) throws SQLException, ClassNotFoundException,Inusedexception{

        Customer custormer = new Customer(

                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getCuctermerNumber(),
                customer.getCuctermerBirthdayMonth(),
                customer.getCuctermerWeight(),
                customer.getCuctermerEmail(),
                customer.getCuctermerRegisterFees()
        );

         Boolean cach1= custormerDAO.findcustormerByponeNumber(customer.getCuctermerNumber());

if(cach1){

    throw new Inusedexception("Customer Number is already exist");

}

           Boolean cach  = custormerDAO.save(custormer);

           return cach == true ? "Customer saved successfully" : "Customer not saved";

    }

    @Override
    public boolean deleteCustomerById(String customerId) throws SQLException, ClassNotFoundException {

         return custormerDAO.delete(customerId);


    }
}
