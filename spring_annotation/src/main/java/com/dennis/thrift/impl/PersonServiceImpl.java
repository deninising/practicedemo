package com.dennis.thrift.impl;

import com.dennis.generated.DataException;
import com.dennis.generated.Person;
import com.dennis.generated.PersonService;
import org.apache.thrift.TException;


public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByName(String name) throws DataException, TException {

        Person person = new Person();
        person.setName(name);
        person.setAge(53);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("客户端储存person对象：" + person.getName() + "--" + person.getName());
    }
}
