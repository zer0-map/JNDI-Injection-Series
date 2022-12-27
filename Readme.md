JNDI (Java Naming and Directory Interface) is a Java API that allows clients to discover and look up data and objects via a name. It can be used to obtain naming and directory services from several service providers where these objects are stored: LDAP(Lightweight Directory Access Protocol), and  Java RMI registry (Remote Method Invocation) and etc. . 

JNDI is a simple Java API that takes just one string parameter, but if the parameter is tainted by an attacker, a victim application can be connected to a malicious LDAP/RMI server and execute arbitrary command.
