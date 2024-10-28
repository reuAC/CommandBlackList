# CommandBlackList
轻量的服务器范围内指令黑名单。  

## 介绍
该插件适用于Spigot1.8及以上。  

支持控制整个服务器范围内的指令，阻止存在于黑名单内的指令被执行。  
支持单独控制特定世界进行黑名单限制。  
支持令黑名单以内的指令不得自动补全。  
**由于相关特性生效于1.13，故应用于自动补全的限制在1.13及以上的版本生效。**  
## 指令
`/commandblacklist` 重载配置。  
**缩写：`/cblist`**

## 配置文件
插件成功启动后，会在plugins文件夹下生成配置文件，位于 `plugins/CommandBlackList/config.yml`  

```yaml
Worlds:
  #生效于特定世界：world_a是世界名称
  world_a:
    #指令黑名单列表
    Command_BlackList:
      - "help"
      - "list"
      - "spawn"
    #是否启用下面的提示
    enabledMessage: true
    #执行黑名单之外的指令后，向玩家发送的提示。
    CommandNotAllow_Tip:
      - "&a禁止执行"
      - "&cExecution Prohibited"
      - "&b実行禁止"
# 您可以按照如下格式添加配置。
#  world_b:
#    #指令黑名单列表
#    Command_BlackList:
#      - "list"
#      - "spawn"
#    #是否启用下面的提示
#    enabledMessage: true
#    #执行黑名单之外的指令后，向玩家发送的提示。
#    CommandNotAllow_Tip:
#      - "&a禁止执行"
#      - "&cExecution Prohibited"
#      - "&b実行禁止"
  DefaultConfig:
    #指令黑名单列表
    Command_BlackList:
      - "help"
      - "list"
      - "spawn"
    #是否启用下面的提示
    enabledMessage: true
    #执行黑名单之外的指令后，向玩家发送的提示。
    CommandNotAllow_Tip:
      - "&a禁止执行"
      - "&cExecution Prohibited"
      - "&b実行禁止"
# 默认对所有世界都生效的配置
Default:
  # 配置名称
  name: "DefaultConfig"
  # 是否启用该配置对所有世界
  enable: true
```

## 权限节点
`commandblacklist.main` 使用重载指令。  
`commandblacklist.bypass.世界名称` 绕过特定世界的黑名单限制。  
`commandblacklist.bypass.*` 绕过全部世界的黑名单限制。

## 使用方法
1. 将编译完成的jar包放入plugins文件夹中，重启服务器。
