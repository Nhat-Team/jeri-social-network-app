import CustomAvatar from "@/components/styles/CustomAvatar";
import CustomIcon from "@/components/styles/CustomIcon";
import CustomSafeAreaView from "@/components/styles/CustomSafeAreaView";
import CustomSpacer from "@/components/styles/CustomSpacer";
import CustomText from "@/components/styles/CustomText";
import CustomTouchableOpacity from "@/components/styles/CustomTouchableOpacity";
import { useLanguage } from "@/hooks/useLanguage";
import { RootState } from "@/redux/store";
import MaterialCommunityIcons from "@expo/vector-icons/MaterialCommunityIcons";
import { Pressable, View } from "react-native";
import { useSelector } from "react-redux";
import MaterialIcons from '@expo/vector-icons/MaterialIcons';
import { Router, useRouter } from "expo-router";
import FontAwesome6 from '@expo/vector-icons/FontAwesome6';

export default function TabProfile() {

  const router: Router = useRouter();
  const language = useLanguage();
  const user = useSelector((state: RootState) => state.user);

  return (
    <CustomSafeAreaView backgroundPriority="secondary" styles={{
      padding: 0,
    }}>
      {/* Profile */}
      <CustomTouchableOpacity
        backgroundPriority="secondary"
        styles={{
          display: "flex",
          flexDirection: "row",
          alignItems: "center",
          justifyContent: "space-between",
          borderRadius: 0,
          borderColor: "transparent",
          borderWidth: 0,
          padding: 20
        }}
      >
        <View
          style={{
            display: "flex",
            flexDirection: "row",
            alignItems: "center",
            justifyContent: "flex-start",
          }}
        >
          <CustomAvatar
            uri=""
            styles={{
              width: 60,
              height: 60,
            }}
          />

          <View style={{
            paddingLeft: 10,
          }}>
            <CustomText content={user.firstName + " " + user.lastName} />

            <CustomText
              subtitle={true}
              content={language.profile.view_profile_subtitle}
              styles={{
                marginTop: 10,
              }}
            />
          </View>
        </View>

        <Pressable style={{marginRight: 10}}>
          <CustomIcon
            icon={
              <MaterialCommunityIcons
                name="account-convert-outline"
                size={30}
              />
            }
          />
        </Pressable>
      </CustomTouchableOpacity>

      <CustomSpacer />

      {/* Storage */}
      <CustomTouchableOpacity 
      backgroundPriority="secondary"
      borderAllow={false}
      styles={{
        display: "flex",
        flexDirection: "row",
        alignItems: "center",
        padding: 20,
      }} props={{
        onPress: () => {

        }
      }}>
        <CustomIcon icon={<FontAwesome6 name="cloud" size={30} />} />

        <View style={{
          display: "flex",
          flexDirection: "column",
          marginLeft: 20,
        }}>
          <CustomText content={language.profile.my_document.tab_name} />

          <CustomText subtitle={true} content={language.profile.my_document.subtitle} styles={{
            marginTop: 10
          }}/>
        </View>
      </CustomTouchableOpacity>

      <CustomSpacer />

      {/* Account and Security */}
      <CustomTouchableOpacity 
      borderAllow={false}
      backgroundPriority="secondary"
      styles={{
        display: "flex",
        flexDirection: "row",
        alignItems: "center",
        padding: 20,
      }} props={{
        onPress: () => {
          router.push("/profile/account_and_security")
        }
      }}>
        <CustomIcon icon={<MaterialIcons name="security" size={30} />} />

        <CustomText content={language.profile.account_and_security.tab_name} styles={{
          marginLeft: 20
        }}/>
      </CustomTouchableOpacity>
    </CustomSafeAreaView>
  );
}
