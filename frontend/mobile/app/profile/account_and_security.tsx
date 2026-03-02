import CustomAvatar from "@/components/styles/CustomAvatar";
import CustomIcon from "@/components/styles/CustomIcon";
import CustomLineSpacer from "@/components/styles/CustomLineSpacer";
import CustomSafeAreaView from "@/components/styles/CustomSafeAreaView";
import CustomSpacer from "@/components/styles/CustomSpacer";
import CustomText from "@/components/styles/CustomText";
import CustomTouchableOpacity from "@/components/styles/CustomTouchableOpacity";
import { useLanguage } from "@/hooks/useLanguage";
import Feather from "@expo/vector-icons/Feather";
import FontAwesome6 from "@expo/vector-icons/FontAwesome6";
import Fontisto from "@expo/vector-icons/Fontisto";
import Ionicons from "@expo/vector-icons/Ionicons";
import { Text, View } from "react-native";

export default function AccountAndSecurity() {
  const language = useLanguage().profile.account_and_security;

  console.log(language);

  return (
    <CustomSafeAreaView
      backgroundPriority="secondary"
      styles={{
        padding: 0,
      }}
    >
      {/* Account Section */}
      <View
        style={{
          padding: 20,
        }}
      >
        <CustomText content={language.account.label} />

        <CustomTouchableOpacity
          backgroundPriority="secondary"
          styles={{
            display: "flex",
            flexDirection: "row",
            alignItems: "center",
            marginTop: 20,
          }}
        >
          <CustomAvatar
            uri=""
            styles={{
              width: 60,
              height: 60,
            }}
          />

          <View
            style={{
              marginLeft: 20,
            }}
          >
            <CustomText content={language.account.personal_information} />

            <CustomText content="" />
          </View>
        </CustomTouchableOpacity>
      </View>

      <CustomLineSpacer />

      <CustomTouchableOpacity
        backgroundPriority="secondary"
        borderAllow={false}
        styles={{
          display: "flex",
          flexDirection: "row",
          alignItems: "center",
          padding: 20,
        }}
      >
        <CustomIcon icon={<Feather name="phone" size={30} style={{
            width: 30
        }} />} />

        <View
          style={{
            display: "flex",
            flexDirection: "column",
            marginLeft: 20,
          }}
        >
          <CustomText content={language.account.phone_number_label} />

          <CustomText content="" />
        </View>
      </CustomTouchableOpacity>

      <CustomLineSpacer />

      <CustomTouchableOpacity
        backgroundPriority="secondary"
        borderAllow={false}
        styles={{
          display: "flex",
          flexDirection: "row",
          alignItems: "center",
          padding: 20,
        }}
      >
        <CustomIcon icon={<Fontisto name="email" size={30} style={{
            width: 30
        }} />} />

        <View
          style={{
            display: "flex",
            flexDirection: "column",
            marginLeft: 20,
          }}
        >
          <CustomText content={language.account.email_label} />

          <CustomText content="" />
        </View>
      </CustomTouchableOpacity>

      <CustomSpacer />

      {/* Security Section */}
      <View
        style={{
          padding: 20,
        }}
      >
        <CustomText content={language.security.label} />
      </View>

      <CustomTouchableOpacity
        backgroundPriority="secondary"
        borderAllow={false}
        styles={{
          display: "flex",
          flexDirection: "row",
          alignItems: "center",
          padding: 20,
        }}
      >
        <CustomIcon icon={<Feather name="key" size={30} style={{
            width: 30
        }} />} />

        <View
          style={{
            display: "flex",
            flexDirection: "column",
            marginLeft: 20,
          }}
        >
          <CustomText content={language.security.change_password} />

          <CustomText subtitle={true} content={language.security.change_password_subtitle} />
        </View>
      </CustomTouchableOpacity>

      <CustomLineSpacer />

      <CustomTouchableOpacity
        backgroundPriority="secondary"
        borderAllow={false}
        styles={{
          display: "flex",
          flexDirection: "row",
          alignItems: "center",
          padding: 20,
        }}
      >
        <CustomIcon icon={<Ionicons name="qr-code-outline" size={30} style={{
            width: 30
        }}/>} />

        <View
          style={{
            display: "flex",
            flexDirection: "column",
            marginLeft: 20,
          }}
        >
          <CustomText content={language.security.two_factor_authentication} />

          <CustomText content="" />
        </View>
      </CustomTouchableOpacity>

      <CustomLineSpacer />

      <CustomTouchableOpacity
        backgroundPriority="secondary"
        borderAllow={false}
        styles={{
          display: "flex",
          flexDirection: "row",
          alignItems: "center",
          padding: 20,
        }}
      >
        <CustomIcon icon={<FontAwesome6 name="x" size={30} style={{
            width: 30
        }} />} />

        <View
          style={{
            display: "flex",
            flexDirection: "column",
            marginLeft: 20,
          }}
        >
          <CustomText content={language.security.delete_account} />
        </View>
      </CustomTouchableOpacity>
    </CustomSafeAreaView>
  );
}
