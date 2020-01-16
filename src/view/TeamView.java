package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
    public static void main(String[] args) {
	TeamView view = new TeamView();
	view.enterMainMenu();
    }

    private NameListService listServ = new NameListService();
    private TeamService teamServ = new TeamService();

    public void enterMainMenu() {
	boolean flag = true;
	while (flag) {
	    listAllEmployees();
	    System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
	    char menuSelection = TSUtility.readMenuSelection();
	    switch (menuSelection) {
	    case '1':
		getTeam();
		break;

	    case '2':
		addMember();
		break;

	    case '3':
		deleteMember();
		break;

	    case '4':
		System.out.print("确认是否退出(Y/N):");
		char confirmSelection = TSUtility.readConfirmSelection();
		if (confirmSelection == 'Y') {
		    flag = false;
		}
		break;
	    }
	}
    }

    /**
     * 显示所有员工信息
     */
    private void listAllEmployees() {
	System.out.println("----------------------------开发团队调度软件----------------------------\n");
	Employee[] allEmployees = listServ.getAllEmployees();
	System.out.println("ID\t姓名\t年龄 \t工资\t职位 \t状态\t奖金\t股票\t领用设备");
	for (int i = 0; i < allEmployees.length; i++) {
	    System.out.println(allEmployees[i]);
	}
	System.out.println("--------------------------------------------------------------------");

    }

    private void getTeam() {
	System.out.println("----------------------------开发团队成员列表----------------------------");
	Programmer[] team = teamServ.getTeam();
	if(team == null || team.length == 0) {
	    System.out.println("暂无成员！");
	}else {
	    System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金 \t股票");
	    for (int i = 0; i < team.length; i++) {
		System.out.println(team[i].getDetailsForTeam());
		
	    }
	}
	System.out.println("--------------------------------------------------------------------");


    }

    private void addMember() {
	System.out.println("----------------------------添加成员----------------------------");
	System.out.println("请输入要添加的员工ID：");
	int id = TSUtility.readInt();
	try {
	    Employee employee = listServ.getEmployee(id);
	    teamServ.addMember(employee);
	    System.out.println("添加成功");
	    TSUtility.readReturn();
	} catch (TeamException e) {
	   
	    System.out.println("添加失败！");
	    System.out.println("原因：" + e.getMessage());
	}
	

    }

    private void deleteMember() {
	System.out.println("----------------------------删除成员----------------------------");
	System.out.println("请输入要删除的员工TID：");
	int tid = TSUtility.readInt();
	System.out.print("确认是否删除(Y/N):");
	char isDel = TSUtility.readConfirmSelection();
	if(isDel == 'N') {
	    return;
	}
	try {
	    teamServ.removeMember(tid);
	    System.out.println("删除成功！");
	} catch (TeamException e) {
	    System.out.println("删除失败！");
	    System.out.println("原因：" + e.getMessage());
	}
	TSUtility.readReturn();

    }

}
