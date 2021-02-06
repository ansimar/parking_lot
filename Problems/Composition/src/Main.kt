// write the classes here
class OperatingSystem(var name: String = "Mac")

class DualBoot(
    var primaryOs: OperatingSystem = OperatingSystem(),
    var secondaryOs: OperatingSystem = OperatingSystem("Ubuntu")
)