package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Process {
    private String name;
    private long pid;

    public Process() {
    }

    public Process(String name, long pid) {
        this.name = name;
        this.pid = pid;
    }

    public List<Process> getAllProcesses() {
        List<Process> processes = new ArrayList<>();
        ProcessHandle.allProcesses().forEach(process -> {
            processes.add(new Process(process.info().command().orElse(""), process.pid()));
        });
        return processes;
    }

    public void listAllProcesses(List<Process> list) {
        list.forEach(process -> {
            System.out.println(process.toString());
        });
    }

    public void killProcessByPid(long pid) {
        try {
            Runtime.getRuntime().exec("kill " + pid);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void suspendProcessByPid(long pid) {
        try {
            Runtime.getRuntime().exec("kill -SIGSTOP " + pid);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void resumeProcessByPid(long pid) {
        try {
            Runtime.getRuntime().exec("kill -SIGCONT " + pid);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void killProcessByName(String name) {
        try {
            Runtime.getRuntime().exec("pkill " + name);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void suspendProcessByName(String name) {
        try {
            Runtime.getRuntime().exec("pkill -STOP " + name);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void resumeProcessByName(String name) {
        try {
            Runtime.getRuntime().exec("pkill -CONT " + name);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Process process = (Process) o;
        return Objects.equals(pid, process.pid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid);
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", pid=" + pid +
                '}';
    }
}