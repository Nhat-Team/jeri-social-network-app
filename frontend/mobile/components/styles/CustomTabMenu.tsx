import { useAppTheme } from "@/hooks/useAppTheme";
import { Pressable, Text } from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";

export default function CustomTabMenu({
  menuName,
  menuSelected,
  setMenuSelected,
}: {
  menuName: string[];
  menuSelected: number;
  setMenuSelected: (index: number) => void;
}) {
    
  const theme = useAppTheme();

  return (
    <SafeAreaView
      style={{
        display: "flex",
        flexDirection: "row",
        backgroundColor: theme.colors.backgroundSecondary,
      }}
    >
      {menuName.map((name, index) => {
        return (
          <Pressable key={index} onPress={() => setMenuSelected(index)} style={{
            flex: 1
          }}>
            <Text
              style={{
                textAlign: "center",
                color: theme.colors.textColor,
                fontSize: theme.typography.body.fontSize,
                fontWeight:
                  index === menuSelected
                    ? "bolder"
                    : theme.typography.body.fontWeight,
                padding: theme.spacing.m,
                borderColor: index === menuSelected ? theme.colors.primary : "transparent",
                borderBottomWidth: 3,
              }}
            >
              {name}
            </Text>
          </Pressable>
        );
      })}
    </SafeAreaView>
  );
}
