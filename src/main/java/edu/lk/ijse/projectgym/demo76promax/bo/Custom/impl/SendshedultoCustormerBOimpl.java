package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.bo.Custom.SendshedultoCustormerBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.SendshedultocustormerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;

public class SendshedultoCustormerBOimpl implements SendshedultoCustormerBO {

    private SendshedultocustormerDAO sendshedultocustormerDAO= DAOFactory.getInstance().getDao(DAOTipes.SENDSHEDULTOCUSTOMER);

}
