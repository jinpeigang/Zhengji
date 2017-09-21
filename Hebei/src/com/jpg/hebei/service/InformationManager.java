package com.jpg.hebei.service;

import java.util.List;

import com.jpg.hebei.model.Information;

public interface InformationManager {
	public abstract void add(Information ifn) throws Exception;
	public Information loadInformation(String companyName);
    public boolean existsInformation(Information ifn);
    public List<Information> listMyInformations(String companyName);
    public Information loadInformation(int id);
    public void delInformation(int id);
    public void updateInformation(Information ifn);
    public List<Information> listInformations(int flage);
    public List<Information> listInformations(String guanli,int flage);
}
