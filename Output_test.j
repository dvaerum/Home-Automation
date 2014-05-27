.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public kitchenSwitch LHOME/classes/standard/Input;
.field public kitchenLamp1 LHOME/classes/standard/Output;
.field public kitchenLamp2 LHOME/classes/standard/Output;
.field public kitchenLamp3 LHOME/classes/standard/Output;
.field public kitchenLamps Ljava/util/ArrayList;
.field public kitchenThermostat1 LHOME/classes/standard/AnalogInput;
.field public kitchenThermostat2 LHOME/classes/standard/AnalogInput;
.field public kitchenThermostat3 LHOME/classes/standard/AnalogInput;
.field public kitchenThermostat4 LHOME/classes/standard/AnalogInput;
.field public kitchenThermostats Ljava/util/HashMap;
.field public kitchenAirCond LHOME/classes/standard/AnalogOutput;
.field public thermostat LHOME/classes/standard/AnalogInput;
.field public radiator LHOME/classes/standard/AnalogOutput;
.method public <init>()V
    .limit stack 16
    .limit locals 14
    aload_0
    invokespecial java/lang/Object/<init>()V
.line 2
    aload_0
    new HOME/classes/standard/Input
    dup
    bipush 1
    invokespecial HOME/classes/standard/Input.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenSwitch LHOME/classes/standard/Input;
.line 3
    aload_0
    new HOME/classes/standard/Output
    dup
    bipush 2
    invokespecial HOME/classes/standard/Output.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenLamp1 LHOME/classes/standard/Output;
.line 4
    aload_0
    new HOME/classes/standard/Output
    dup
    bipush 3
    invokespecial HOME/classes/standard/Output.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenLamp2 LHOME/classes/standard/Output;
.line 5
    aload_0
    new HOME/classes/standard/Output
    dup
    bipush 4
    invokespecial HOME/classes/standard/Output.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenLamp3 LHOME/classes/standard/Output;
.line 6
    aload_0
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 5
    aload 5
    aload_0
    getfield HOME/kitchenLamp1 LHOME/classes/standard/Output;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload_0
    getfield HOME/kitchenLamp2 LHOME/classes/standard/Output;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload_0
    getfield HOME/kitchenLamp3 LHOME/classes/standard/Output;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload_0
    swap
    putfield HOME/kitchenLamps Ljava/util/ArrayList;
.line 9
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 5
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenThermostat1 LHOME/classes/standard/AnalogInput;
.line 10
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 6
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenThermostat2 LHOME/classes/standard/AnalogInput;
.line 11
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 7
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenThermostat3 LHOME/classes/standard/AnalogInput;
.line 12
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 8
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenThermostat4 LHOME/classes/standard/AnalogInput;
.line 13
    aload_0
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 10
    aload 10
    ldc "thermo1"
    aload_0
    getfield HOME/kitchenThermostat1 LHOME/classes/standard/AnalogInput;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    ldc "thermo2"
    aload_0
    getfield HOME/kitchenThermostat2 LHOME/classes/standard/AnalogInput;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    ldc "thermo3"
    aload_0
    getfield HOME/kitchenThermostat3 LHOME/classes/standard/AnalogInput;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    ldc "thermo4"
    aload_0
    getfield HOME/kitchenThermostat4 LHOME/classes/standard/AnalogInput;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    aload_0
    swap
    putfield HOME/kitchenThermostats Ljava/util/HashMap;
.line 14
    aload_0
    new HOME/classes/standard/AnalogOutput
    dup
    bipush 9
    invokespecial HOME/classes/standard/AnalogOutput.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenAirCond LHOME/classes/standard/AnalogOutput;
.line 17
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 10
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/thermostat LHOME/classes/standard/AnalogInput;
.line 18
    aload_0
    new HOME/classes/standard/AnalogOutput
    dup
    bipush 11
    invokespecial HOME/classes/standard/AnalogOutput.<init>(I)V
    aload_0
    swap
    putfield HOME/radiator LHOME/classes/standard/AnalogOutput;
return
.end method

.method public Setup()V
    .limit stack 3
    .limit locals 2
.line 21
    aload_0
    getfield HOME/kitchenSwitch LHOME/classes/standard/Input;
    ldc "ON_TOGGLED"
    ldc "toggleKitchenLamps"
    invokevirtual HOME/classes/standard/Input/registerEvent(Ljava/lang/String;Ljava/lang/String;)V
.line 22
    aload_0
    getfield HOME/thermostat LHOME/classes/standard/AnalogInput;
    ldc "ON_CHANGED"
    ldc "handleTemperatureChanges"
    invokevirtual HOME/classes/standard/AnalogInput/registerEvent(Ljava/lang/String;Ljava/lang/String;)V
.line 27
    aload_0
    invokevirtual HOME/getAverageKitchenTemperature()I
    istore 1
.line 28
    aload_0
    getfield HOME/kitchenAirCond LHOME/classes/standard/AnalogOutput;
    bipush 25
    iload 1
    isub
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual HOME/classes/standard/AnalogOutput.setValue(I)V
    return
.end method

.method public getAverageKitchenTemperature()I
    .limit stack 4
    .limit locals 6
.line 33
    bipush 10
    istore 1
.line 35
    bipush 1
    istore 2
.line 36
    Label1:
    iload 2
    bipush 4
    if_icmpgt Label2
.line 37
    aload_0
    getfield HOME/kitchenThermostats Ljava/util/HashMap;
    ldc "thermo"
    iload 2
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/lang/Integer.toString()Ljava/lang/String;
    astore 5
    astore 4
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 4
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 5
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast HOME/classes/standard/AnalogInput
    astore 5
.line 39
    iload 2
    iconst_1
    iadd
    istore 2
    goto Label1
    Label2:
.line 42
    iload 1
    bipush 4
    idiv
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    bipush 4
    idiv
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public handleTemperatureChanges()V
    .limit stack 2
    .limit locals 2
.line 47
    aload_0
    getfield HOME/thermostat LHOME/classes/standard/AnalogInput;
    invokevirtual HOME/classes/standard/AnalogInput.getValue()I
    istore 1
.line 49
    iload 1
    bipush 10
    if_icmplt Label3
.line 51
    iload 1
    bipush 20
    if_icmpgt Label4
.line 54
    aload_0
    getfield HOME/radiator LHOME/classes/standard/AnalogOutput;
    bipush 1
    putfield HOME/classes/standard/AnalogOutput/value I
    goto Label5
    Label3:
.line 50
    aload_0
    getfield HOME/radiator LHOME/classes/standard/AnalogOutput;
    bipush 5
    putfield HOME/classes/standard/AnalogOutput/value I
    goto Label5
    Label4:
.line 52
    aload_0
    getfield HOME/radiator LHOME/classes/standard/AnalogOutput;
    bipush 3
    putfield HOME/classes/standard/AnalogOutput/value I
    goto Label5
    Label5:
    return
.end method

.method public toggleKitchenLamps()V
    .limit stack 1
    .limit locals 3
.line 61
    aload_0
    getfield HOME/kitchenLamps Ljava/util/ArrayList;
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 1
    Label6:
    aload 1
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label7
    aload 1
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast HOME/classes/standard/Output
    astore 2
.line 62
    aload 2
    invokevirtual HOME/classes/standard/Output.toggle()V
    goto Label6
    Label7:
    return
.end method

